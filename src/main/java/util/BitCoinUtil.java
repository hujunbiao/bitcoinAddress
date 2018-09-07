package util;

import com.google.common.base.Joiner;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.crypto.HDUtils;
import org.bitcoinj.wallet.DeterministicKeyChain;
import org.bitcoinj.wallet.DeterministicSeed;

import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;

/**
 * @author: kingflag
 * @create: 2018-09-07 11:19
 **/
public class BitCoinUtil {

    public static final Joiner SPACE_JOINER = Joiner.on(" ");

    /**
     * 生成助记词文件
     *
     * @param filePathname 文件路径
     * @param fileName     文件名
     * @param content      内容
     * @return
     */
    public static Boolean createFile(String filePathname, String fileName, String content) {

        try {
            File mnemonicCodeFilePath = new File(filePathname);
            if (!mnemonicCodeFilePath.exists()) {
                mnemonicCodeFilePath.mkdirs();
            }
            File file = new File(filePathname + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //将助记词保存到文件中 助记词非常重要
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 根据 【助记词】 和 【path】 生成 【ECKey】
     *
     * @param mnemonicCode 助记词
     * @param path         索引
     * @return
     */
    public ECKey createECKeyByMnemonicCodeAndPath(String mnemonicCode, String path) {
        try {
            DeterministicSeed deterministicSeed = new DeterministicSeed(mnemonicCode, null, "", 0L);
            DeterministicKeyChain deterministicKeyChain = DeterministicKeyChain.builder().seed(deterministicSeed).build();
            BigInteger privHexKey = deterministicKeyChain.getKeyByPath(HDUtils.parsePath(path), true).getPrivKey();
            ECKey ecKey = ECKey.fromPrivate(privHexKey);
            return ecKey;
        } catch (Exception e) {
            return null;
        }
    }
}
