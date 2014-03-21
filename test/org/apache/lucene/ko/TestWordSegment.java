package org.apache.lucene.ko;

import java.util.List;

import org.apache.lucene.analysis.ko.morph.AnalysisOutput;
import org.apache.lucene.analysis.ko.morph.WordSpaceAnalyzer;

import junit.framework.TestCase;

public class TestWordSegment extends TestCase {

	public void testWordSegment() throws Exception {
		
		String[] texts = new String[] {
//				"나는학교에갔다",
				"진산세"
		};
		
//		text = "푸미폰국왕은존경을받고있다";
//		text = "학교및학원";
		
		for(String text : texts) {
			WordSpaceAnalyzer analyzer = new WordSpaceAnalyzer();
			List<AnalysisOutput> result = analyzer.analyze(text);
			
			System.out.println("=======results=========");
			for(AnalysisOutput o : result) {
				System.out.print(o.getSource()+", ");
			}
			System.out.println();
		}

	}

}
