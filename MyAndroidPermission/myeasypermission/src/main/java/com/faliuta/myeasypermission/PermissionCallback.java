package com.faliuta.myeasypermission;

import java.io.Serializable;

/**
 * Created by FVolodia on 02.06.17.
 */

public interface PermissionCallback extends Serializable {
    void onClose();

    void onFinish();

    void onDeny(String permission, int position);

    void onGuarantee(String permission, int position);
}
