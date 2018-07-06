package com.wb.cpedata.network;

import com.wb.cpedata.util.utils.F;
import com.wb.cpedata.util.utils.CPEDataParserLogger;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;


public class SecureFlxHttpClient extends DefaultHttpClient {

    @Override
    protected ClientConnectionManager createClientConnectionManager() {
        CPEDataParserLogger.d(F.TAG, "SecureFlxHttpClient.createClientConnectionManager");
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", new EasySSLSocketFactory(), 443));
        return new SingleClientConnManager(getParams(), schemeRegistry);
    }
}