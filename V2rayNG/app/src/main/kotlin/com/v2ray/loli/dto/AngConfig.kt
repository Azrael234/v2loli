package com.v2ray.loli.dto

data class AngConfig(
        var index: Int,
        var vmess: ArrayList<VmessBean>,
        var subItem: ArrayList<SubItemBean>
) {
    data class VmessBean(var guid: String = "123456",
                         var address: String = "loli.yes",
                         var port: Int = 10086,
                         var id: String = "23333333-2333-2333-2333-233333333333",
                         var alterId: Int = 64,
                         var security: String = "aes-128-cfb",
                         var network: String = "tcp",
                         var remarks: String = "2333",
                         var headerType: String = "",
                         var requestHost: String = "",
                         var path: String = "",
                         var streamSecurity: String = "",
                         var configType: Int = 1,
                         var configVersion: Int = 1,
                         var subid: String = "")

    data class SubItemBean(var id: String = "",
                           var remarks: String = "",
                           var url: String = "")
}
