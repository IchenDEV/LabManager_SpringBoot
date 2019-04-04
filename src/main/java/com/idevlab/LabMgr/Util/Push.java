package com.idevlab.LabMgr.Util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.util.concurrent.ExecutionException;

import com.idevlab.LabMgr.Service.PushMsgService;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;

import nl.martijndwars.webpush.Notification;
import nl.martijndwars.webpush.PushService;
import nl.martijndwars.webpush.Utils;

public class Push {
    @Autowired
    PushMsgService pushMsgService;

    public void pushMsg(String endpoint, String userPublicKey, String userAuth, String payload)
            throws GeneralSecurityException, IOException, JoseException, ExecutionException, InterruptedException {
        Security.addProvider(new BouncyCastleProvider());
        PushService pushService = new PushService();
        pushService.setPublicKey(Utils.loadPublicKey(
                "BGjdZhE3KbD6QksVK-buZ83zxe_E55iSsibnPXTI541WfSOHxPjgGNg-pnaF_pDWPcUoNNaSrRrA_pb-fmSyvkw"));
        pushService.setPrivateKey(Utils.loadPrivateKey("qm2ElR5Y0iZpBR5xYDZbue6h-dbat54vqMTnqt8yUmM"));
        pushService.setSubject("https://lab.idevlab.cn");
        Notification notification = new Notification(endpoint, userPublicKey, userAuth, payload);
        System.out.print("try");
        var xp = pushService.sendAsync(notification);
        System.out.print(xp);
    }

}