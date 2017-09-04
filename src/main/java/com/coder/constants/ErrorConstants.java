package com.coder.constants;

public class ErrorConstants {

    public static final ErrorPair SUCCESS = ErrorPair.of(0, "成功");

    public static final ErrorPair UNKNOWN_ERROR = ErrorPair.of(-1, "系统繁忙");

    public static final ErrorPair REQUEST_PARA_ERROR = ErrorPair.of(1000, "请求参数有误!");

    public static final ErrorPair REQUEST_CONTENT_NOT_FOUND = ErrorPair.of(1001, "请求内容不存在");

    public static final ErrorPair ENUM_NOT_FOUND = ErrorPair.of(1003, "类型不存在");

    public static final ErrorPair CHAIN_NOT_FOUND = ErrorPair.of(1004, "未找到任何区块链");

    public static final ErrorPair NODE_NOT_FOUND = ErrorPair.of(1005, "未找到任何节点");

    public static final ErrorPair UC_NOT_FOUND = ErrorPair.of(1006, "uc不存在");

    public static final ErrorPair UPDATE_COUNT_ZERO = ErrorPair.of(1007, "操作频繁,请稍候再试!");

    public static final ErrorPair RETRY_INFO = ErrorPair.of(1008, "外围系统重试");

    public static final ErrorPair INVALID_PARAMETER = ErrorPair.of(1009, "参数不合法");

    public static final ErrorPair NOT_EXIST_ABS_KEY = ErrorPair.of(1010, "不存在ABS密钥");

    public static final ErrorPair WORD_LENGTH_TOO_LONG = ErrorPair.of(1011, "文字长度超出限制");

    public static final ErrorPair SIGN_ERROR = ErrorPair.of(1012, "签名验证失败");

    public static final ErrorPair SECRET_KEY_COMMON_NOT_FOUND_ERROR = ErrorPair.of(2001, "通用密钥不存在");

    public static final ErrorPair SECRET_KEY_COMMON_ALREADY_EXIST_ERROR = ErrorPair.of(2002, "通用密钥已存在");

    public static final ErrorPair SECRET_KEY_COMMON_ADD_ERROR = ErrorPair.of(2003, "添加通用密钥失败");

    public static final ErrorPair SECRET_KEY_CHAIN_KEY_NOT_FOUND_ERROR = ErrorPair.of(2004, "链密钥不存在");

    public static final ErrorPair SECRET_KEY_CHAIN_KEY_UPDATE_ERROR = ErrorPair.of(2005, "链密钥更新失败");

    public static final ErrorPair SECRET_KEY_CLIENT_KEY_NOT_FOUND_ERROR = ErrorPair.of(2006, "操作端密钥不存在");

    public static final ErrorPair SECRET_KEY_CLIENT_KEY_ALREADY_EXIST_ERROR = ErrorPair.of(2007, "操作端密钥已存在");

    public static final ErrorPair SECRET_KEY_CLIENT_KEY_ADD_ERROR = ErrorPair.of(2008, "操作端密钥添加失败");

    public static final ErrorPair CERT_ROOT_EXIST_ERROR = ErrorPair.of(2009, "根证书已存在");

    public static final ErrorPair CERT_ROOT_NOT_FOUND_ERROR = ErrorPair.of(2010, "根证书不存在");

    public static final ErrorPair CERT_ROOT_KEY_NOT_FOUND_ERROR = ErrorPair.of(2011, "根证书私钥不存在");

    public static final ErrorPair CERT_ROOT_CREATE_ERROR = ErrorPair.of(2012, "创建根证书失败");

    public static final ErrorPair CERT_EXIST_ERROR = ErrorPair.of(2013, "证书已存在");

    public static final ErrorPair CERT_NOT_FOUND_ERROR = ErrorPair.of(2014, "证书不存在");

    public static final ErrorPair CERT_CREATE_CERT_FILE_ERROR = ErrorPair.of(2015, "生成证书文件失败");

    public static final ErrorPair CERT_CA_FILES_DIR_NOT_EXIST_ERROR = ErrorPair.of(2016, "证书目录不存在");

    public static final ErrorPair CERT_PLATFORM_CERT_NOT_FOUND_ERROR = ErrorPair.of(2017, "开放平台证书不存在");

    public static final ErrorPair CERT_CREATE_TMP_FILES_DIR_ERROR = ErrorPair.of(2018, "创建临时文件目录失败");

    public static final ErrorPair CERT_CNF_FILE_NOT_FOUND_ERROR = ErrorPair.of(2019, "默认证书配置模板不存在");

    public static final ErrorPair CERT_UPDATE_USER_EXT_ERROR = ErrorPair.of(2020, "更新用户关联证书ID失败");

    public static final ErrorPair CERT_IPS_NOT_FOUND_ERROR = ErrorPair.of(2021, "未获得IP或域名信息");

    public static final ErrorPair CERT_IP_INVALID_ERROR = ErrorPair.of(2022, "节点IP不合法");

    public static final ErrorPair CERT_PUBLIC_KEY_INVALID_ERROR = ErrorPair.of(2023, "公钥格式不合法");

    public static final ErrorPair SECRET_KEY_ALGORITHM_ERROR = ErrorPair.of(2024, "密钥算法错误");

    public static final ErrorPair SECRET_KEY_PLATFORM_COMMON_KEY_NOT_FOUND_ERROR = ErrorPair.of(2025, "开放平台公钥不存在");

    public static final ErrorPair CREATE_CHAIN_ERROR = ErrorPair.of(3001, "创建区块链过程出错");

    public static final ErrorPair PARTICIPANT_REDIS_NULL = ErrorPair.of(3002, "参与方缓存信息为空");

    public static final ErrorPair HTTPS_ERROR = ErrorPair.of(4001, "https错误");

    public static final ErrorPair CREATE_REPEAT_NODE = ErrorPair.of(5001, "创建重复节点");

    public static final ErrorPair NO_UPDATE_NODE_STATUS_AUTHORITY = ErrorPair.of(5002, "没有节点状态修改权限");

    public static final ErrorPair ONLY_NODE_NOT_INVALID = ErrorPair.of(5003, "唯一有效节点不能禁用!");

    public static final ErrorPair ZOO_CREATE_NODE_ERROR = ErrorPair.of(6001, "zooKeeper创建节点失败");

    public static final ErrorPair ZOO_DETELE_NODE_ERROR = ErrorPair.of(6002, "zooKeeper删除节点失败");

    public static final ErrorPair ZOO_QUERY_NODE_ERROR = ErrorPair.of(6003, "zooKeeper查询子节点失败");

    public static final ErrorPair ZOO_QUERY_NODE_NULL = ErrorPair.of(6004, "您名下所有节点都存在异常!");

    public static final ErrorPair NODE_NOT_ACTIVE = ErrorPair.of(6005, "当前节点未激活");

    public static final ErrorPair NODE_NOT_PROVIDE = ErrorPair.of(6006, "未提供节点信息");

    public static final ErrorPair REDIS_NODE_MASTER_NULL = ErrorPair.of(7001, "Redis_master为空");

    public static final ErrorPair APPLY_CHAIN_ERROR_CHAIN_ID = ErrorPair.of(8002, "不存在该区块链");

    public static final ErrorPair APPLY_ALREADY_EXISTS = ErrorPair.of(8003, "已申请该区块链");

    public static final ErrorPair NO_APPLY = ErrorPair.of(8004, "不存在区块链申请");

    public static final ErrorPair DB_INSERT_ERROR = ErrorPair.of(9001, "添加失败");

    public static final ErrorPair NODE_ACCESS_MORE_THAN_ONE_ERROR = ErrorPair.of(9002, "同一路径下最多只能有一个节点");

    public static final ErrorPair NO_AVAILABLE_COMMITER = ErrorPair.of(9003, "没有可用的committer");

    public static final ErrorPair NO_PARTICIPANT_CACHE_ERROR = ErrorPair.of(9004, "参与方缓存信息不存在");

    public static final ErrorPair PARTICIPANT_KEY_NOT_EXIST = ErrorPair.of(9005, "参与方key不存在");

    public static class ErrorPair {

        private int code;

        private String desc;

        private ErrorPair(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static ErrorPair of(int code, String desc) {
            return new ErrorPair(code, desc);
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}
