package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: kingflag
 * @create: 2018-09-07 10:46
 **/
@Entity
@Table(name = "escrow_address")
public class EscrowAddressPo implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 1（比特币），2（以太坊）
     */
    @Column(name = "coin_type")
    private Integer coinType;

    /**
     * 钱包地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 地址类型 0（收币），1（发币）
     */
    @Column(name = "address_type")
    private Integer addressType;

    /**
     * 地址公钥
     */
    @Column(name = "pub_key")
    private String pubKey;

    /**
     * 钱包索引
     */
    @Column(name = "`index`")
    private Integer index;

    /**
     * 所属助记词
     */
    @Column(name = "belong_to")
    private String belongTo;

    /**
     * 地址状态： 1（空闲）；2（使用中）；3（禁用）
     */
    @Column(name = "address_state")
    private Integer addressState;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;


    /**
     * get 主键
     */
    public String getId() {
        return id;
    }

    /**
     * set 主键
     */
    public EscrowAddressPo setId(String id) {
        this.id = id;
        return this;
    }


    /**
     * get 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * set 用户id
     */
    public EscrowAddressPo setUserId(String userId) {
        this.userId = userId;
        return this;
    }


    /**
     * get 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * set 用户密码
     */
    public EscrowAddressPo setPassword(String password) {
        this.password = password;
        return this;
    }


    /**
     * get 1（比特币），2（以太坊）
     */
    public Integer getCoinType() {
        return coinType;
    }

    /**
     * set 1（比特币），2（以太坊）
     */
    public EscrowAddressPo setCoinType(Integer coinType) {
        this.coinType = coinType;
        return this;
    }


    /**
     * get 钱包地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * set 钱包地址
     */
    public EscrowAddressPo setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * get 地址类型 0（收币），1（发币）
     */
    public Integer getAddressType() {
        return addressType;
    }

    /**
     * set 地址类型 0（收币），1（发币）
     */
    public EscrowAddressPo setAddressType(Integer addressType) {
        this.addressType = addressType;
        return this;
    }

    /**
     * get 地址公钥
     */
    public String getPubKey() {
        return pubKey;
    }

    /**
     * set 地址公钥
     */
    public EscrowAddressPo setPubKey(String pubKey) {
        this.pubKey = pubKey;
        return this;
    }


    /**
     * get 钱包索引
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * set 钱包索引
     */
    public EscrowAddressPo setIndex(Integer index) {
        this.index = index;
        return this;
    }


    /**
     * get 所属助记词
     */
    public String getBelongTo() {
        return belongTo;
    }

    /**
     * set 所属助记词
     */
    public EscrowAddressPo setBelongTo(String belongTo) {
        this.belongTo = belongTo;
        return this;
    }


    /**
     * get 地址状态： 1（空闲）；2（使用中）；3（禁用）
     */
    public Integer getAddressState() {
        return addressState;
    }

    /**
     * set 地址状态： 1（空闲）；2（使用中）；3（禁用）
     */
    public EscrowAddressPo setAddressState(Integer addressState) {
        this.addressState = addressState;
        return this;
    }


    /**
     * get 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * set 创建时间
     */
    public EscrowAddressPo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }


    /**
     * get 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * set 更新时间
     */
    public EscrowAddressPo setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String toString() {
        return "EscrowAddressPo{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", coinType=" + coinType +
                ", address='" + address + '\'' +
                ", addressType=" + addressType +
                ", pubKey='" + pubKey + '\'' +
                ", index=" + index +
                ", belongTo='" + belongTo + '\'' +
                ", addressState=" + addressState +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
