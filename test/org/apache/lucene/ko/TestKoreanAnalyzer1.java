package org.apache.lucene.ko;

import junit.framework.TestCase;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.ko.KoreanAnalyzer;
import org.apache.lucene.analysis.ko.MorphemeAttribute;
import org.apache.lucene.analysis.tokenattributes.*;

import java.io.StringReader;

/**
 * Created by SooMyung(soomyung.lee@gmail.com) on 2014. 7. 30.
 */

public class TestKoreanAnalyzer1 extends TestCase {

    public void testKoreanAnalzer() throws Exception {

        String[] sources = new String[] {
//                "고려 때 중랑장(中郞將) 이돈수(李敦守)의 12대손이며",
                "이돈수(李敦守)의",
//                "K·N의 비극"
        };

        KoreanAnalyzer analyzer = new KoreanAnalyzer();

        for(String source : sources) {
            TokenStream stream = analyzer.tokenStream("dummy", new StringReader(source));

            CharTermAttribute termAtt = stream.addAttribute(CharTermAttribute.class);
            PositionIncrementAttribute posIncrAtt = stream.addAttribute(PositionIncrementAttribute.class);
            PositionLengthAttribute posLenAtt = stream.addAttribute(PositionLengthAttribute.class);
            TypeAttribute typeAtt = stream.addAttribute(TypeAttribute.class);
            OffsetAttribute offsetAtt = stream.addAttribute(OffsetAttribute.class);
            MorphemeAttribute morphAtt = stream.addAttribute(MorphemeAttribute.class);
            stream.reset();

            while(stream.incrementToken()) {
                System.out.println(termAtt.toString());
            }
            stream.close();
        }

    }
}
