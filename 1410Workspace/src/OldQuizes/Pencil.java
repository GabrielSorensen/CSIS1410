/**
 * 
 * @author
 *
 */
public class Pencil {
	
	/**
	 * This is the no argument constructor
	 * When a pencil is constructed with this constructor it should have
	 * a full eraser (that is able to erase 150 characters)
	 * It cannot write any characters.  Note: once the pencil is
	 * sharpened it can write up to 25 characters until it needs to be sharpened again
	 * 
	 */
	
	private int eraserUses;
	private int pencilUses;
	
	public Pencil(){
		this.eraserUses = 150;
		this.pencilUses = 25;
	}
	
	/**
	 * This is the 2 argument constructor
	 * @param eraserCapacity, The number of characters the eraser can erase until empty
	 * @param numOfCharactersUntilSharpenedAgain, The number of characters the pencil can write until dull
	 * 
	 * GOTCHAS: Don't allow negative eraserCapacity, set eraser capacity to 0
	 * GOTCHAS: Don't allow negative sharpness,      set sharpness to 0
	 */
	public Pencil(int eraserCapacity, int numOfCharactersUntilSharpenedAgain){
		if (eraserCapacity<0) {
			this.eraserUses = 0;
		} else {
			this.eraserUses = eraserCapacity;
		}
		if (numOfCharactersUntilSharpenedAgain<0) {
			this.pencilUses = 0;
		} else {
			this.pencilUses = numOfCharactersUntilSharpenedAgain;
		}
		
	}

	/**
	 * Replaces the eraser with a new one.
	 * 
	 * @param newEraserCapacity
	 * 
	 * GOTCHAS: Don't allow negative newEraserCapacity, set eraser capacity to 0
	 */
	public void setOrReplaceEraser(int newEraserCapacity){
		if (newEraserCapacity<0) {
			this.eraserUses = 0;
		} else {
			this.eraserUses = newEraserCapacity;
		}
	}

	/**
	 * @return the number of characters the eraser can currently erase
	 */
	public int getEraserCapacity(){
		return this.eraserUses;
	}

	/**
	 * @return the number of characters the pencil can still write until dull
	 */
	public int getNumOfCharsUntilPencilIsDull(){
		return this.pencilUses;
	}

	/**
	 * This method should allow (set) the pencil to write 45 characters
	 */
	public void sharpenPencil(){
		this.pencilUses = 45;
	}
	
	/**
	 * @return true if the pencil can still write characters, false otherwise
	 */
	public boolean canStillWrite(){
		if (pencilUses>0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return true if the eraser can still erase characters, false otherwise
	 */
	public boolean canStillErase(){
		if (eraserUses>0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method writes a character. (Don't worry about which character, or how)
	 * After the method is called, the pencil can write 1 fewer characters, but not less than 0 total
	 * 
	 * @return true if the pencil was able to write, false otherwise
	 */
	public boolean usePencilToWriteACharacter(){
		if (pencilUses>0) {
			this.pencilUses -=1;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method erases a character. (Don't worry about which character or how)
	 * After the method is called, the pencil can erase 1 fewer characters, but not less than 0
	 * 
	 * @return true if the pencil was able to erase, false otherwise
	 */
	public boolean usePencilToEraseACharacter(){
		if (eraserUses>0) {
			this.eraserUses -=1;
			return true;
		} else {
			return false;
		}
	}
	
}
