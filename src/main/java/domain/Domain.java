package domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.crypto.HDUtils;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.wallet.DeterministicKeyChain;
import org.bitcoinj.wallet.DeterministicSeed;
import org.bitcoinj.wallet.Wallet;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.*;
import entity.*;
import util.BitCoinUtil;


/**
 * Created by Jesus on 21.09.2017.
 */
public class Domain {
    private static final Logger logger = LogManager.getLogger(Domain.class);

    public static void main(String[] args) {

        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

            EscrowAddressPoRepository escrowAddressPoRepository = context.getBean(EscrowAddressPoRepository.class);

            NetworkParameters params = MainNetParams.get();
            Wallet transactionWallet = new Wallet(params);
            DeterministicSeed transactionSeed = transactionWallet.getKeyChainSeed();
            String mnemonicCode = BitCoinUtil.SPACE_JOINER.join(transactionSeed.getMnemonicCode());
            System.out.println(mnemonicCode);
            List<EscrowAddressPo> escrowAddressPoList = new ArrayList<EscrowAddressPo>();
            int total = 100;
            for (int i = 0; i < total; i++) {
                StringBuffer keyByPath = new StringBuffer("44H / 0H / 0H / 0 / ").append(i);
                DeterministicSeed deterministicSeed = new DeterministicSeed(mnemonicCode, null, "", 0L);
                DeterministicKeyChain deterministicKeyChain = DeterministicKeyChain.builder().seed(deterministicSeed).build();
                BigInteger privHexKey = deterministicKeyChain.getKeyByPath(HDUtils.parsePath(keyByPath.toString()), true).getPrivKey();
                ECKey ecKey = ECKey.fromPrivate(privHexKey);
                String privKey = ecKey.getPrivateKeyEncoded(params).toString();
                Address address = ecKey.toAddress(params);
                logger.info(i + " privKey:" + privKey + " ********** " + "address:" + address.toBase58());

                EscrowAddressPo escrowAddressPo = new EscrowAddressPo();

                escrowAddressPo.setCoinType(1);
                escrowAddressPo.setAddress(address.toBase58());
                escrowAddressPo.setAddressType(0);
                escrowAddressPo.setPubKey("456");
                escrowAddressPo.setIndex(i);
                escrowAddressPo.setBelongTo("5656");
                escrowAddressPo.setAddressState(0);
                escrowAddressPo.setCreateTime(new Date());
                escrowAddressPoRepository.save(escrowAddressPo);
                escrowAddressPoList.add(escrowAddressPo);
                if (escrowAddressPoList.size() == 100) {
                    escrowAddressPoRepository.saveAll(escrowAddressPoList);
                    escrowAddressPoList.clear();
                } else if (i == total - 1) {
                    escrowAddressPoRepository.saveAll(escrowAddressPoList);
                    escrowAddressPoList.clear();
                }
            }
        } catch (Exception e) {
            logger.error("处理出现异常:{}", e);
        }


    }
}
