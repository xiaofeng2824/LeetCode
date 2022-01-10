package test;

import java.util.List;

public class MysqlDataSourceTest {

    public static void main(String[] args) {

        String user  = "yh_dev";
        String passwd = "DvpJe2x";
        String connectionUrl = "jdbc:mysql://10.195.6.58:8066/inventory_omni_channel_center?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
        String sql = "select * from t_omni_location_type_stock  where site_code='9010' and sku_code='1111' and storage_code='0001' and owner_code='500'  and location_type='1'";

        List list = CommonFunctionProvider.connectDBQuery(user, passwd, connectionUrl, sql);

        System.out.println("---");
    }
}
