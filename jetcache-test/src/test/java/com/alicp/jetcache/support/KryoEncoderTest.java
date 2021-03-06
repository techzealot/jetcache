package com.alicp.jetcache.support;

import org.junit.jupiter.api.Test;

/**
 * Created on 2016/10/8.
 *
 * @author <a href="mailto:areyouok@gmail.com">huangli</a>
 */
public class KryoEncoderTest extends AbstractEncoderTest {
    @Test
    public void test() {
        encoder = KryoValueEncoder.INSTANCE;
        decoder = KryoValueDecoder.INSTANCE;
        super.baseTest();

    }

    @Test
    public void compoundTest() {
        encoder = (p) -> KryoValueEncoder.INSTANCE.apply(KryoValueEncoder.INSTANCE.apply(p));
        decoder = (p) -> KryoValueDecoder.INSTANCE.apply((byte[]) KryoValueDecoder.INSTANCE.apply(p));
        baseTest();

        encoder = (p) -> KryoValueEncoder.INSTANCE.apply(JavaValueEncoder.INSTANCE.apply(p));
        decoder = (p) -> JavaValueDecoder.INSTANCE.apply((byte[]) KryoValueDecoder.INSTANCE.apply(p));
        baseTest();
    }

    @Test
    public void compatibleTest() {
        encoder = KryoValueEncoder.INSTANCE;
        decoder = JavaValueDecoder.INSTANCE;
        baseTest();
    }

}
