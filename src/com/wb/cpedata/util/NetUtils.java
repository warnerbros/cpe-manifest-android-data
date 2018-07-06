package com.wb.cpedata.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import org.apache.http.conn.util.InetAddressUtils;

import com.wb.cpedata.util.utils.CPEDataParserLogger;
import com.wb.cpedata.util.utils.F;

import android.content.Context;
import android.net.ConnectivityManager;


public class NetUtils {
	
	public static String getIP(boolean useIPv4) {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()) {
						String sAddr = inetAddress.getHostAddress().toUpperCase();
						boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
						if (useIPv4) {
							if (isIPv4) {
								CPEDataParserLogger.d(F.TAG, "Local IP: " + sAddr);
								return sAddr;
							}
						} else {
							if (!isIPv4) {
								int delim = sAddr.indexOf('%'); // drop ip6 port suffix
								String ipv6 = delim<0 ? sAddr : sAddr.substring(0, delim);
								CPEDataParserLogger.d(F.TAG, "Local IP: " + ipv6);
								return ipv6;
							}
						}
					}
				}
			}
		} catch (SocketException ex) {
			CPEDataParserLogger.e(F.TAG, ex.toString(), ex);
		}
		return "";
	}
	
	public static boolean isInternetAvalable(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
	}
	
}
