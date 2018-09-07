# bitcoinAddress
批量创建比特币账户地址

添加bitcoinj依赖
```$maven  
<dependency>
      <groupId>org.bitcoinj</groupId>
      <artifactId>bitcoinj-core</artifactId>
      <version>0.14.7</version>
</dependency>
```

创建表
```$sql
CREATE TABLE `escrow_address` (
  `id` varchar(44) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '主键',
  `user_id` varchar(44) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户id',
  `password` varchar(44) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户密码',
  `coin_type` int(3) DEFAULT NULL COMMENT '1（比特币），2（以太坊）',
  `address` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '钱包地址',
  `address_type` int(3) DEFAULT NULL COMMENT '地址类型 0（收币），1（发币）',
  `pub_key` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '地址公钥',
  `index` int(11) DEFAULT NULL COMMENT '钱包索引',
  `belong_to` varchar(30) DEFAULT NULL COMMENT '所属助记词',
  `address_state` int(3) DEFAULT NULL COMMENT '地址状态： 1（空闲）；2（使用中）；3（禁用）',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='托管地址';

```