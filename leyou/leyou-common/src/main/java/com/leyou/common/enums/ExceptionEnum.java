package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 枚举 具有固定实例个数的类
 * 枚举 中的构造函数默认私有
 * 枚举必须定义在最前面，以 , 分隔
 * PRICE_CANNOT_BE_NULL(400, "价格不能为空") 等价于
 *      public static final ExceptionEnum PRICE_CANNOT_BE_NULL = new ExceptionEnum(400, "价格不能为空")
 * @author xiaoNan
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    CATEGORY_NOT_FOUND(404, "商品分类不存在"),
    BRAND_NOT_FOUND(404, "品牌不存在"),
    SPEC_GROUP_NOT_FOUND(404, "商品规格组不存在"),
    SPEC_PARAM_NOT_FOUND(404, "商品规格参数不存在"),
    GOODS_NOT_FOUND(404, "商品不存在"),
    GOODS_DETAIL_NOT_FOUND(404, "商品详情不存在"),
    GOODS_SKU_NOT_FOUND(404, "商品sku不存在"),
    GOODS_STOCK_NOT_FOUND(404, "商品库存不存在"),
    BRAND_SAVE_ERROR(500, "新增品牌失败"),
    UPLOAD_FILE_ERROR(500, "文件上传失败"),
    GOODS_SAVE_ERROR(500, "新增商品失败"),
    GOODS_UPDATE_ERROR(500, "修改商品失败"),
    INVALID_FILE_TYPE(400, "无效的文件类型"),
    GOODS_ID_CANNOT_BE_NULL(400, "商品id不能为空"),
    INVALID_USER_DATA_TYPE(400, "用户的数据类型无效"),
    INVALID_VERIFY_CODE(400, "无效的验证码"),
    INVALID_USERNAME_PASSWORD(400, "用户名或密码错误"),
    CREATE_TOKEN_ERROR(500, "用户凭证生成失败"),
    CART_NOT_FOUND(404, "购物车为空"),
    UNAUTHORIZED(403, "未授权"),
    CREATE_ORDER_ERROR(500, "创建订单失败"),
    CREATE_DETAIL_ORDER_ERROR(500, "创建订单详情失败"),
    STOCK_NOT_ENOUGH(500, "库存不足"),
    ORDER_NOT_FOUND(404, "订单不存在"),
    ORDER_DETAIL_NOT_FOUND(404, "订单详情不存在"),
    ORDER_STATUS_NOT_FOUND(404, "订单状态不存在"),
    WX_PAY_ORDER_FAIL(500, "微信下单失败"),
    ORDER_STATUS_ERROR(400, "订单状态不正确"),
    INVALID_SIGN_ERROR(400, "无效的签名异常"),
    INVALID_ORDER_PARAM(400, "订单参数异常"),
    UPDATE_ORDER_STATUS_ERROR(500, "更新订单状态失败"),
    ;
    private int code;
    private String msg;
}
