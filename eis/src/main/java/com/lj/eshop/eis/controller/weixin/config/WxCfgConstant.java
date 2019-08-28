package com.lj.eshop.eis.controller.weixin.config;


/**
 * 
 * 类说明：公众号配置。
 *  
 * 
 * <p>
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月6日
 */
public class WxCfgConstant {

    // 交易类型
    public static final String TRADE_TYPE = "JSAPI";
    /** 微信统一支付地址*/
    public static final String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    // 加密的key
    //public static final String KEY = "";

    //公众账号ID
    //public static final String APPID ="";

    //商户号
    //public static final String MCH_ID = "";

    /** 获取code重定向地址*/
    //public static final String REDIRECT_URL = "";

    /** 微信授权地址*/
    public static final String REQCODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";

    /** 应用密钥AppSecret*/
  //  public static final String SECRET = "";

    /** 获取access_token openid地址*/
    public static final String ACSTOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

    /** 刷新access_token有效期url */
    public static final String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

    /** 微信支付回调url */
 //   public static final String NOTIFY_URL = "";

    //
    public static final String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";

    public static final String ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

    /** 下载多媒体URL */
    public static final String GET_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get";
    /** 获取微信用户URL */
    public static final String GET_USER_INFO="https://api.weixin.qq.com/sns/userinfo";

}
