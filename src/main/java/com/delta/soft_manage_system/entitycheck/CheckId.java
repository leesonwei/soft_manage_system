package com.delta.soft_manage_system.entitycheck;

/**
 * @Classname CheckId
 * @Date 2019/3/26 08:29
 * @Author LIZONG.WEI
 * @Since 1.8
 */
public enum CheckId {
    /**
     * 數據庫的id類型
     */
    AUTO(0, "数据库ID自增"),
    INPUT(1, "用户输入ID"),
    ID_WORKER(2, "全局唯一ID"),
    UUID(3, "全局唯一ID"),
    NONE(4, "该类型为未设置主键类型"),
    ID_WORKER_STR(5, "字符串全局唯一ID");

    private final int key;
    private final String desc;

    private CheckId(int key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static CheckId getIdType(int idType) {
        CheckId[] its = values();
        CheckId[] arr$ = its;
        int len$ = its.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            CheckId it = arr$[i$];
            if (it.getKey() == idType) {
                return it;
            }
        }

        return ID_WORKER;
    }

    public int getKey() {
        return this.key;
    }

    public String getDesc() {
        return this.desc;
    }
}