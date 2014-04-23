package MC2d;

import static MC2d.World.BLOCKS_HEIGHT;
import static MC2d.World.BLOCKS_WIDTH;
import static MC2d.World.BLOCK_SIZE;

public class BlockGrid {
	private Block[][] blocks = new Block[BLOCKS_WIDTH][BLOCKS_HEIGHT];
	public BlockGrid(){
		for (int x=0; x<BLOCKS_WIDTH - 1; x++ ){
			for (int y= 0; y<BLOCKS_HEIGHT - 1; y++){
				blocks[x][y] = new Block(BlockType.AIR, x * BLOCK_SIZE, y * BLOCK_SIZE);
			}
		}
	}
	public void setAt(int x2, int y2, BlockType b1){
		blocks[x2][y2] = new Block(b1, x2 * BLOCK_SIZE, y2 * BLOCK_SIZE);
	}
	public Block getAt(int x2, int y2){
		return blocks[x2][y2];
	}
	public void draw(){
		for (int xx=0; xx<BLOCKS_WIDTH - 1; xx++ ){
			for (int yy= 0; yy<BLOCKS_HEIGHT - 1; yy++){
				blocks[xx][yy].draw();
			}
		}
	}
}
