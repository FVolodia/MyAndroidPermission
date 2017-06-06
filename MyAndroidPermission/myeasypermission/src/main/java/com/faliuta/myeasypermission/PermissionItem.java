package com.faliuta.myeasypermission;

import java.io.Serializable;

/**
 * Created by FVolodia on 02.06.17.
 */

public class PermissionItem implements Serializable {
    public String PermissionName;
    public String Permission;

    public PermissionItem(String permission, String permissionName) {
        Permission = permission;
        PermissionName = permissionName;
    }

    public PermissionItem(String permission) {
        Permission = permission;
    }
}
