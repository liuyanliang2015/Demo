package com.test.networkSecurity.ip;

import javax.servlet.http.HttpServletRequest;


/**
 * 获取客户端IP来源
 * 如果服务器有白名单策略，可以判断客户端IP是否在白名单区间内
 */
public class IpAdrressUtil {
    
    /**
     * 获取客户端的IP来源
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {   
        String ip = request.getHeader("x-forwarded-for");   
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
            ip = request.getHeader("Proxy-Client-IP");   
        }   
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
            ip = request.getHeader("WL-Proxy-Client-IP");   
        }   
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
            ip = request.getRemoteAddr();   
        }   
        return ip;   
    }   
    
    
    /**
     * 判断IP是否在某一个IP端
     * @param ipSection
     * @param ip
     * @return
     */
    public static boolean ipIsValid(String ipSection, String ip) {  
        if (ipSection == null)  
            throw new NullPointerException("IP段不能为空！");  
        if (ip == null)  
            throw new NullPointerException("IP不能为空！");  
        ipSection = ipSection.trim();  
        ip = ip.trim();  
        final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";  
        final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;  
        if (!ipSection.matches(REGX_IPB) || !ip.matches(REGX_IP))  
            return false;  
        int idx = ipSection.indexOf('-');  
        String[] sips = ipSection.substring(0, idx).split("\\.");  
        String[] sipe = ipSection.substring(idx + 1).split("\\.");  
        String[] sipt = ip.split("\\.");  
        long ips = 0L, ipe = 0L, ipt = 0L;  
        for (int i = 0; i < 4; ++i) {  
            ips = ips << 8 | Integer.parseInt(sips[i]);  
            ipe = ipe << 8 | Integer.parseInt(sipe[i]);  
            ipt = ipt << 8 | Integer.parseInt(sipt[i]);  
        }  
        if (ips > ipe) {  
            long t = ips;  
            ips = ipe;  
            ipe = t;  
        }  
        return ips <= ipt && ipt <= ipe;  
    }  
    
    public static void main(String[] args) {
    	boolean flag = ipIsValid("49.112.0.0-49.119.255.255", "49.116.0.20");
    	System.out.println(flag);
	}
}
