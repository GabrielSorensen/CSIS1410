/**
 * 
 * @author Dr B
 *
 */
public class PencilGrader {

	public static void main(String[] args) {
		int points = 100;
		int deduction = 100/10;


		//Test the constructors and the getters
		Pencil blank15 = new Pencil();
		if (blank15.getEraserCapacity() != 150 || blank15.getNumOfCharsUntilPencilIsDull() != 25 || blank15.canStillErase() == false || blank15.canStillWrite() == false){
			System.err.println("Creating a new Pencil using the no argument constructor should be able to erase 150 characters, write 25 caracters, can still write and can still erase.\n  This error could also be caused by your getter methods not returning the correct values");
			points -= deduction;
		}

		//Test the constructors and the getters
		int randEraser = (int)(Math.random()*1000+10);
		int randWrite = (int)(Math.random()*1000+10);
		Pencil blank20 = new Pencil(randEraser,randWrite);
		if (blank20.getEraserCapacity() != randEraser || blank20.getNumOfCharsUntilPencilIsDull() != randWrite || blank20.canStillErase() == false || blank20.canStillWrite() == false){
			System.err.println("Creating a new Pencil using the 2 argument constructor with " + randEraser + " " + randWrite + " should be able to erase " + randEraser+ " characters, write " + randWrite + " caracters, can still write and can still erase.\n  This error could also be caused by your getter methods not returning the correct values");
			points -= deduction;
		}

		//Test bad values in the constructor
		randEraser = (int)(Math.random()*1000+10)*-1;
		randWrite = (int)(Math.random()*1000+10)*-1;
		Pencil badPencil = new Pencil(randEraser,randWrite);
		if (badPencil.getEraserCapacity() != 0 || badPencil.getNumOfCharsUntilPencilIsDull() != 0 || badPencil.canStillErase() == true || badPencil.canStillWrite() == true){
			System.err.println("Creating a new Pencil using the 2 argument constructor with " + randEraser + " " + randWrite + " should be able to erase 0 characters, write 0 caracters, cannot write and cannot erase.\n  This error could also be caused by your getter methods not returning the correct values");
			points -= deduction;
		}

		//Try replacing the eraser
		badPencil.setOrReplaceEraser(randEraser*-1);
		blank15.setOrReplaceEraser(randWrite*-1);
		if(badPencil.getEraserCapacity() != randEraser*-1 || blank15.getEraserCapacity() != randWrite*-1){
			System.err.println("setOrReplaceEraser did not work correctly");
			points -= deduction;
		}

		//Try replacing the eraser with bad values
		badPencil.setOrReplaceEraser(randEraser*2);
		blank15.setOrReplaceEraser(randWrite*3);
		if(badPencil.getEraserCapacity() != 0 || blank15.getEraserCapacity() != 0){
			System.err.println("setOrReplaceEraser with negative values did not set the value to 0");
			points -= deduction;
		}

		//Try sharpening the pencil
		badPencil.sharpenPencil();
		blank20.sharpenPencil();
		if(badPencil.getNumOfCharsUntilPencilIsDull() != 45 || blank20.getNumOfCharsUntilPencilIsDull() != 45){
			System.err.println("sharpenPencil did not set the number of characters until pencil is dull to 45");
			points -= deduction;
		}

		//Try writing characters
		for (int i = 44; i > 0; i--){
			badPencil.usePencilToWriteACharacter();
			blank20.usePencilToWriteACharacter();
			if(badPencil.getNumOfCharsUntilPencilIsDull() != i || blank20.getNumOfCharsUntilPencilIsDull() != i || badPencil.canStillWrite() == false || blank20.canStillWrite() == false){
				System.err.println("usePencilToWriteACharacter did not specify 1 fewer character in getNumOfCharsUntilPencilIsDull or the canStillWrite method is not returning true");
				points -= deduction;
				break;
			}
		}
		//Try writing into the negative
		for (int i = 0; i < 10; i++){
			badPencil.usePencilToWriteACharacter();
			blank20.usePencilToWriteACharacter();
			if(badPencil.getNumOfCharsUntilPencilIsDull() != 0 || blank20.getNumOfCharsUntilPencilIsDull() != 0 || badPencil.canStillWrite() == true || blank20.canStillWrite() == true){
				System.err.println("usePencilToWriteACharacter on empty did not change canStillWrite to false or numOfCharacters is not 0");
				points -= deduction;
				break;
			}
		}


		//Try erasing characters
		int newEraser = (int)(Math.random()*60+60);
		badPencil.setOrReplaceEraser(newEraser);
		blank20.setOrReplaceEraser(newEraser);
		for (int i = newEraser-1; i > 0; i--){
			badPencil.usePencilToEraseACharacter();
			blank20.usePencilToEraseACharacter();
			if(badPencil.getEraserCapacity() != i || blank20.getEraserCapacity() != i || badPencil.canStillErase() == false || blank20.canStillErase() == false){
				System.err.println("usePencilToEraseACharacter did not specify 1 fewer character in getEraserCapacity or the canStillErase method is not returning true");
				points -= deduction;
				break;
			}
		}
		//try erasing into the negative
		for (int i = 0; i < 10; i++){
			badPencil.usePencilToEraseACharacter();
			blank20.usePencilToEraseACharacter();
			if(badPencil.getEraserCapacity() != 0 || blank20.getEraserCapacity() != 0 || badPencil.canStillErase() == true || blank20.canStillErase() == true){
				System.err.println("usePencilToWriteACharacter did not change canStillWrite to false or numOfCharacters is not 0");
				points -= deduction;
				break;
			}
		}

		System.out.println("Your graded percentage for this assignment is: " + points);

	}

}
