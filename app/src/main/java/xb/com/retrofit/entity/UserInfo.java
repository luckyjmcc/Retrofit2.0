package xb.com.retrofit.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/16.
 */
public class UserInfo implements Serializable {
    Integer leiXing;//类型
    String yongHuMing;//用户名
    String niCheng;//昵称
    String xingMing;//姓名
    Integer woDeZiYuanShu;//我的资源数
    Integer woDeXuanShangShu;//我的悬赏数
    String keYongJinE;//可用金额
    String keYongYuE;//可用金额
    String zongJinE;//总金额
    String chuShengRiQi;//总金额

    String zongYuE;
    String ni_cheng;

    String yong_hu_ming;
    String dianZiYouXiang;

    String touXiangUrl;
    String beiKeXiaoErId;

    String yongHuId;//:"用户id",
    String touXiang;// "touXiang":"头像",
    String xianShiMing;//"":"显示名",
    String pengYouBiaoZhi;//:"朋友标志，0：是好友，1：不是好友 , 2:为自己",
    String diZhi;// "diZhi":"地址",
    Integer nianLing;//"nianLing":"年龄",
    Integer xingBie;//"性别，0：女，1：男",
    Integer xueDuan;//  "xueDuan":"学段",
    Integer nianJi;//  "nianJi":"年级",
    Integer xueKe;// "xueKe":"学科",
    String xiaoQu;//  "xiaoQu":"校区",
    Integer ziYuanZongShu;// "ziYuanZongShu":"资源总数",

    String xianJuZhuDi;
    String dianHua;


    @Override
    public String toString() {
        return new StringBuilder()
                .append("leiXing").append("=").append(leiXing).append("\n")
                .append("yongHuMing").append("=").append(yongHuMing).append("\n")
                .append("niCheng").append("=").append(niCheng).append("\n")
                .append("xingMing").append("=").append(xingMing).append("\n")
                .append("woDeZiYuanShu").append("=").append(woDeZiYuanShu).append("\n")
                .append("woDeXuanShangShu").append("=").append(woDeXuanShangShu).append("\n")
                .append("keYongJinE").append("=").append(keYongJinE).append("\n")
                .append("keYongYuE").append("=").append(keYongYuE).append("\n")
                .append("zongJinE").append("=").append(zongJinE).append("\n")
                .append("chuShengRiQi").append("=").append(chuShengRiQi).append("\n")
                .append("zongYuE").append("=").append(zongYuE).append("\n")
                .append("ni_cheng").append("=").append(ni_cheng).append("\n")
                .append("yong_hu_ming").append("=").append(yong_hu_ming).append("\n")
                .append("dianZiYouXiang").append("=").append(dianZiYouXiang).append("\n")
                .append("touXiangUrl").append("=").append(touXiangUrl).append("\n")
                .append("beiKeXiaoErId").append("=").append(beiKeXiaoErId).append("\n")
                .append("yongHuId").append("=").append(yongHuId).append("\n")
                .append("touXiang").append("=").append(touXiang).append("\n")
                .append("xianShiMing").append("=").append(xianShiMing).append("\n")
                .append("pengYouBiaoZhi").append("=").append(pengYouBiaoZhi).append("\n")//........
                .toString();
    }

    public Integer getLeiXing() {
        return leiXing;
    }

    public void setLeiXing(Integer leiXing) {
        this.leiXing = leiXing;
    }

    public String getYongHuMing() {
        return yongHuMing;
    }

    public void setYongHuMing(String yongHuMing) {
        this.yongHuMing = yongHuMing;
    }

    public String getNiCheng() {
        return niCheng;
    }

    public void setNiCheng(String niCheng) {
        this.niCheng = niCheng;
    }

    public String getXingMing() {
        return xingMing;
    }

    public void setXingMing(String xingMing) {
        this.xingMing = xingMing;
    }

    public Integer getWoDeZiYuanShu() {
        return woDeZiYuanShu;
    }

    public void setWoDeZiYuanShu(Integer woDeZiYuanShu) {
        this.woDeZiYuanShu = woDeZiYuanShu;
    }

    public Integer getWoDeXuanShangShu() {
        return woDeXuanShangShu;
    }

    public void setWoDeXuanShangShu(Integer woDeXuanShangShu) {
        this.woDeXuanShangShu = woDeXuanShangShu;
    }

    public String getKeYongJinE() {
        return keYongJinE;
    }

    public void setKeYongJinE(String keYongJinE) {
        this.keYongJinE = keYongJinE;
    }

    public String getKeYongYuE() {
        return keYongYuE;
    }

    public void setKeYongYuE(String keYongYuE) {
        this.keYongYuE = keYongYuE;
    }

    public String getZongJinE() {
        return zongJinE;
    }

    public void setZongJinE(String zongJinE) {
        this.zongJinE = zongJinE;
    }

    public String getChuShengRiQi() {
        return chuShengRiQi;
    }

    public void setChuShengRiQi(String chuShengRiQi) {
        this.chuShengRiQi = chuShengRiQi;
    }

    public String getZongYuE() {
        return zongYuE;
    }

    public void setZongYuE(String zongYuE) {
        this.zongYuE = zongYuE;
    }

    public String getNi_cheng() {
        return ni_cheng;
    }

    public void setNi_cheng(String ni_cheng) {
        this.ni_cheng = ni_cheng;
    }

    public String getYong_hu_ming() {
        return yong_hu_ming;
    }

    public void setYong_hu_ming(String yong_hu_ming) {
        this.yong_hu_ming = yong_hu_ming;
    }

    public String getDianZiYouXiang() {
        return dianZiYouXiang;
    }

    public void setDianZiYouXiang(String dianZiYouXiang) {
        this.dianZiYouXiang = dianZiYouXiang;
    }

    public String getTouXiangUrl() {
        return touXiangUrl;
    }

    public void setTouXiangUrl(String touXiangUrl) {
        this.touXiangUrl = touXiangUrl;
    }

    public String getBeiKeXiaoErId() {
        return beiKeXiaoErId;
    }

    public void setBeiKeXiaoErId(String beiKeXiaoErId) {
        this.beiKeXiaoErId = beiKeXiaoErId;
    }

    public String getYongHuId() {
        return yongHuId;
    }

    public void setYongHuId(String yongHuId) {
        this.yongHuId = yongHuId;
    }

    public String getTouXiang() {
        return touXiang;
    }

    public void setTouXiang(String touXiang) {
        this.touXiang = touXiang;
    }

    public String getXianShiMing() {
        return xianShiMing;
    }

    public void setXianShiMing(String xianShiMing) {
        this.xianShiMing = xianShiMing;
    }

    public String getPengYouBiaoZhi() {
        return pengYouBiaoZhi;
    }

    public void setPengYouBiaoZhi(String pengYouBiaoZhi) {
        this.pengYouBiaoZhi = pengYouBiaoZhi;
    }

    public String getDiZhi() {
        return diZhi;
    }

    public void setDiZhi(String diZhi) {
        this.diZhi = diZhi;
    }

    public Integer getNianLing() {
        return nianLing;
    }

    public void setNianLing(Integer nianLing) {
        this.nianLing = nianLing;
    }

    public Integer getXingBie() {
        return xingBie;
    }

    public void setXingBie(Integer xingBie) {
        this.xingBie = xingBie;
    }

    public Integer getXueDuan() {
        return xueDuan;
    }

    public void setXueDuan(Integer xueDuan) {
        this.xueDuan = xueDuan;
    }

    public Integer getNianJi() {
        return nianJi;
    }

    public void setNianJi(Integer nianJi) {
        this.nianJi = nianJi;
    }

    public Integer getXueKe() {
        return xueKe;
    }

    public void setXueKe(Integer xueKe) {
        this.xueKe = xueKe;
    }

    public String getXiaoQu() {
        return xiaoQu;
    }

    public void setXiaoQu(String xiaoQu) {
        this.xiaoQu = xiaoQu;
    }

    public Integer getZiYuanZongShu() {
        return ziYuanZongShu;
    }

    public void setZiYuanZongShu(Integer ziYuanZongShu) {
        this.ziYuanZongShu = ziYuanZongShu;
    }

    public String getXianJuZhuDi() {
        return xianJuZhuDi;
    }

    public void setXianJuZhuDi(String xianJuZhuDi) {
        this.xianJuZhuDi = xianJuZhuDi;
    }

    public String getDianHua() {
        return dianHua;
    }

    public void setDianHua(String dianHua) {
        this.dianHua = dianHua;
    }
}
