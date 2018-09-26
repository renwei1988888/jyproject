package com.merchant.services;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.merchant.constants.Constants;
import com.merchant.utils.AppController;
import com.merchant.utils.AppUtil;
import com.merchant.utils.DateUtil;
import com.merchant.utils.MD5;
import com.merchant.utils.NetworkManager;
import com.merchant.utils.SharedPreferencesUtil;
import com.merchant.utils.SsX509TrustManager;
import com.merchant.weight.DialogManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/710:40
 * desc   : 网络数据处理类
 * version: 1.0
 */
public class DataFetchService implements Response.ErrorListener {

    protected static final String TAG = "DataFetchService";
    public Context mcontext;
    private static final int MY_SOCKET_TIMEOUT_MS = 15000;
    private final String DeviceType = "android";

    private String TimeStamp = "";
    private String Imei = "";
    /*是否自定义了错误信息*/
    private boolean isError;
    private DialogManager dialogManager;

    private DftErrorListener dftErrorListener;

    public DataFetchService(Context mcontext) {
        this.mcontext = mcontext;
        dialogManager = new DialogManager(mcontext);
    }

    public void setOnDftErrorListener(DftErrorListener dftErrorListener) {
        this.dftErrorListener = dftErrorListener;
    }

    public void setisError(boolean isError) {
        this.isError = isError;
    }


    /*----------------此处为网络接口-开始------------------*/
    /*登录*/
    public void doLogin(String username,
                        String password, String client, String methodname, int callType,
                        Response.Listener<JSONObject> listener,
                        Response.ErrorListener errlsn) {
        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("username", username);
            jsonParams.put("password", password);
            jsonParams.put("client", client);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sign = getSignbyJSONObject(jsonParams);
        makeJsonObjReq(methodname, sign, callType, listener, errlsn, jsonParams);
    }

    /*----------------------此处为网络接口-结束------------------------*/

    public String cookieFromResponse;
    private String mHeader;

    /*向后台发送消息*/
    public void makeJsonObjReq(String url, final String sign,
                               final int callMethodeType, Response.Listener<JSONObject> listener,
                               Response.ErrorListener errlsn, JSONObject requestMap) {
        JsonObjectRequest req = null;
        Log.i("url", url);
        if (NetworkManager.checkInternetConnection(mcontext)) {
            SsX509TrustManager.allowAllSSL();
            if (!isError || errlsn == null) {
                errlsn = this;
            }
            req = new JsonObjectRequest(callMethodeType, url, requestMap,
                    listener, errlsn) {
                /**
                 * 重写父类方法，获取登录账户名
                 */
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("UserId",
                            SharedPreferencesUtil.getUserId(mcontext));
                    headers.put("AuthToken",
                            SharedPreferencesUtil.getResult_AuthToken(mcontext));
                    String cookie = SharedPreferencesUtil.getResult_Cookie(
                            mcontext).replace("Cookie=SESSIONID=",
                            "ASP.NET_SessionId=");
                    Log.i("cookie", cookie);
                    headers.put("Cookie", cookie);
                    headers.put("ClientType", DeviceType);
                    if (callMethodeType == Method.GET) {
                        TimeStamp = DateUtil.getTenTime();
                        Imei = AppUtil.getIMEI(mcontext);
                        headers.put("TimeStamp", TimeStamp);
                        headers.put("Imei", Imei);
                        String sign = "";
                        String encSign = "";
                        Map<String, String> paramMap = new TreeMap<String, String>(
                                new Comparator<String>() {
                                    @Override
                                    public int compare(String o1, String o2) {
                                        String str1 = o1.toLowerCase();
                                        String str2 = o2.toLowerCase();
                                        if (str1.compareTo(str2) == 0) {
                                            return o1.compareTo(o2);
                                        }
                                        return str1.compareTo(str2);
                                    }
                                });
                        paramMap.put("TimeStamp", TimeStamp);
                        paramMap.put("Imei", Imei);
                        for (Iterator<String> it = paramMap.keySet().iterator(); it
                                .hasNext(); ) {
                            String key = it.next();
                            encSign = encSign
                                    + (key.toLowerCase() + "="
                                    + paramMap.get(key) + "&");
                        }
                        sign = MD5.md5(encSign.substring(0,
                                encSign.length() - 1)
                                + Constants.encryption_key);
                        headers.put("Sign", sign);
                    } else {
                        headers.put("TimeStamp", TimeStamp);
                        headers.put("Imei", Imei);
                        headers.put("Sign", sign);
                    }
                    return headers;
                }

                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public RetryPolicy getRetryPolicy() {
                    return super.getRetryPolicy();
                }

            };

            req.setRetryPolicy(new DefaultRetryPolicy(MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            AppController.getInstance().addToRequestQueue(req);

        } else {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {

                @Override
                public void run() {
                    dialogManager.initOneBtnDialog("确定", "提示", "网络不给力", null);
                    if (dftErrorListener != null) {
                        dftErrorListener.webLoadError();
                    }
                }
            });
        }

    }

    /*带cookie向后台发送消息*/
    public void makeCookieJsonObjReq(String url, final String sign,
                                     final int callMethodeType, Response.Listener<JSONObject> listener,
                                     Response.ErrorListener errlsn, JSONObject requestMap) {
        JsonObjectRequest req = null;
        if (NetworkManager.checkInternetConnection(mcontext)) {
            SsX509TrustManager.allowAllSSL();
            req = new JsonObjectRequest(callMethodeType, url, requestMap,
                    listener, this) {
                /**
                 * 重写父类方法，获取登录账户名
                 */
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("UserId", SharedPreferencesUtil.getUserId(mcontext));
                    headers.put("AuthToken",
                            SharedPreferencesUtil.getResult_AuthToken(mcontext));
                    headers.put("ClientType", DeviceType);
                    if (callMethodeType == Method.GET) {
                        TimeStamp = DateUtil.getTenTime();
                        Imei = AppUtil.getIMEI(mcontext);
                        headers.put("TimeStamp", TimeStamp);
                        headers.put("Imei", Imei);
                        String sign = "";
                        String encSign = "";
                        Map<String, String> paramMap = new TreeMap<String, String>(
                                new Comparator<String>() {
                                    @Override
                                    public int compare(String o1, String o2) {
                                        String str1 = o1.toLowerCase();
                                        String str2 = o2.toLowerCase();
                                        if (str1.compareTo(str2) == 0) {
                                            return o1.compareTo(o2);
                                        }
                                        return str1.compareTo(str2);
                                    }
                                });
                        paramMap.put("TimeStamp", TimeStamp);
                        paramMap.put("Imei", Imei);
                        for (Iterator<String> it = paramMap.keySet().iterator(); it
                                .hasNext(); ) {
                            String key = it.next();
                            encSign = encSign
                                    + (key.toLowerCase() + "="
                                    + paramMap.get(key) + "&");
                        }
                        sign = MD5.md5(encSign.substring(0,
                                encSign.length() - 1)
                                + Constants.encryption_key);
                        headers.put("Sign", sign);
                    } else {
                        headers.put("TimeStamp", TimeStamp);
                        headers.put("Imei", Imei);
                        headers.put("Sign", sign);
                    }
                    return headers;
                }

                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public RetryPolicy getRetryPolicy() {
                    return super.getRetryPolicy();
                }

                @Override
                protected Response<JSONObject> parseNetworkResponse(
                        NetworkResponse response) {
                    try {
                        String jsonString = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers));
                        mHeader = response.headers.toString();
                        // 使用正则表达式从reponse的头中提取cookie内容的子串
                        Pattern pattern = Pattern.compile("Set-Cookie.*?;");
                        Matcher m = pattern.matcher(mHeader);
                        if (m.find()) {
                            cookieFromResponse = m.group();
                        }
                        // 去掉cookie末尾的分号
                        cookieFromResponse = cookieFromResponse.substring(11,
                                cookieFromResponse.length() - 1);
                        // 将cookie字符串添加到jsonObject中，该jsonObject会被deliverResponse递交，调用请求时则能在onResponse中得到
                        JSONObject jsonObject = new JSONObject(jsonString);
                        jsonObject.put("Cookie", cookieFromResponse);
                        return Response.success(jsonObject,
                                HttpHeaderParser.parseCacheHeaders(response));
                    } catch (Exception e) {
                        return Response.error(new ParseError(e));
                    }
                }

            };

            req.setRetryPolicy(new DefaultRetryPolicy(MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            AppController.getInstance().addToRequestQueue(req);

        } else {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {

                @Override
                public void run() {
                    dialogManager.initOneBtnDialog("确定", "提示", "网络不给力", null);
                    if (dftErrorListener != null) {
                        dftErrorListener.webLoadError();
                    }
                }
            });
        }

    }

    /*post方法加密 根据传的参数得到加密信息*/
    public String getSignbyJSONObject(JSONObject jsonParams) {
        String sign = "";
        String encSign = "";
        TimeStamp = "";
        Imei = AppUtil.getIMEI(mcontext);
        if (jsonParams == null || jsonParams.length() == 0) {
            return sign;
        }
        /*参数小写化*/
        Map<String, String> paramMap = new TreeMap<String, String>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        String str1 = o1.toLowerCase();
                        String str2 = o2.toLowerCase();
                        if (str1.compareTo(str2) == 0) {
                            return o1.compareTo(o2);
                        }
                        return str1.compareTo(str2);
                    }
                });

        paramMap.put("TimeStamp", TimeStamp);
        paramMap.put("Imei", Imei);
        try {
            Iterator<String> it = jsonParams.keys();
            while (it.hasNext()) {
                String key = (String) it.next();
                String value = jsonParams.getString(key);
                paramMap.put(key, value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /*对参数进行拼接*/
        for (Iterator<String> it = paramMap.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            if (paramMap.get(key) != null && !paramMap.get(key).equals("")) {
                encSign = encSign
                        + (key.toLowerCase() + "=" + paramMap.get(key) + "&");
            }
        }
        /*获得MD5加密后的字符串*/
        sign = MD5.md5(
                encSign.substring(0, encSign.length() - 1)
                        + Constants.encryption_key).toLowerCase();

        return sign;
    }

    /*将json字符串映射到具体model*/
    @SuppressWarnings("unchecked")
    public Object GetResponseObject(JSONObject jsonResponse,
                                    @SuppressWarnings("rawtypes") Class class1) {
        Object obj = null;
        try {
            String gson = jsonResponse.toString();
            obj = new Gson().fromJson(gson, class1);
        } catch (Exception e) {
            e.printStackTrace();
            dialogManager.initOneBtnDialog("确定", "提示", "网络不给力", null);
            if (dftErrorListener != null) {
                dftErrorListener.webLoadError();
            }
        }

        return obj;
    }

    /*接口调用网络有关错误*/
    @Override
    public void onErrorResponse(VolleyError volleyError) {
        if (dftErrorListener != null) {
            dftErrorListener.webLoadError();
        }
        if (!NetworkManager.isNetworkAvailable(mcontext)) {
            dialogManager.initOneBtnDialog("确定", "提示", "网络不给力", null);
            return;
        }
        if (volleyError instanceof TimeoutError) {
            Toast.makeText(mcontext, "请求超时", Toast.LENGTH_SHORT).show();
        } else if ((volleyError instanceof NetworkError)
                || (volleyError instanceof NoConnectionError)) {
            Toast.makeText(mcontext, "网络不给力", Toast.LENGTH_SHORT).show();
        }

        if (volleyError.networkResponse != null) {
            String response = new String(volleyError.networkResponse.data);
            // Constants.ClearSharePref(activity.getBaseContext());
            SharedPreferencesUtil.clear_Cookie(mcontext);
            if (response.equals("Invalid Username/Password")) {
                // Constants.ClearSharePref(activity.getBaseContext());
                // Constants.Clear_Cookie(activity.getBaseContext());
                // ActivityManager activityManager = (ActivityManager) activity
                // .getSystemService(Context.ACTIVITY_SERVICE);
                // String runningActivity = activityManager.getRunningTasks(1)
                // .get(0).topActivity.getClassName();

                // com.md.hjyg.activities.HomeActivity
                // if (runningActivity
                // .equals("com.md.hjyg.activities.HomeFragmentActivity"))
                // {
                // // 如果当前活动的为HomeActivity，则不跳转
                // } else
                // {
                // Constants.ClearSharePref(activity);
                dialogManager.initOneBtnDialog("确定", "提示", "您的登录状态已失效，请重新登录！",
                        new DialogInterface.OnDismissListener() {

                            @Override
                            public void onDismiss(DialogInterface dialog) {
//                                Intent loginIntent = new Intent(mcontext,
//                                        MineLoginActivity.class);
//                                mcontext.startActivity(loginIntent);

                            }
                        });

            } else {
                dialogManager.initOneBtnDialog("确定", "提示", "网络不给力", null);
            }
        }

    }

    /*网络接口加载错误接口*/
    public interface DftErrorListener {
        public void webLoadError();
    }
}
