package java_36_h07;

import java.util.Random;

/**
 * 
 * Solve the puzzle until 1 is in the top left corner by randomly moving pieces.
 *
 */
public class SchiebAlg1 implements Loesungsalgorithmus{

	public void loese(Schiebepuzzle sp) {
		
		while(sp.getBoard().indexOf(1) != 0) {
			
			Random r= new Random();
//			int a = r.nextInt(15) + 1;
//			if(sp.istVerschiebbar(a))
//				sp.schiebe(a);
			try {
				sp.schiebe(r.nextInt(15) + 1);
			}catch(WrongMoveException e){
				
			}
		}
	}
}
	