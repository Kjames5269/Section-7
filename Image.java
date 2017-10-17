public class Image {	
	char[][] imgArr;
	private int DEFAULT = 10;
	
	public Image() {
		imgArr = new char[DEFAULT][DEFAULT];
	}
	
	public Image(int x) {
		imgArr = new char[x][x];
	}
	
	public char get(Point p) {
		return imgArr[p.x][p.y];
	}
	
	public Image changeAt(Point p, char f) {
		imgArr[p.x][p.y] = f;
		
		return this;
	}
	
	public Image drawLine(Point begin, Point end, char f) { 
		if(begin.isGreaterEq(end)) {
			Point temp = begin;
			begin = end;
			end = temp;
		}
		
		int x = begin.x;
		int y = begin.y;
		while ( x < end.x || y < end.y ) {
			imgArr[x][y] = f;
			
			if( x != end.x)
				x ++;
			if( y != end.y)
				y ++;
		}
		
		return this;
	}
	
	public Image printImg() {
		for (int i = 0; i < imgArr.length; i ++) {
			for (int j = 0; j < imgArr[i].length; j ++) {
				System.out.print(imgArr[i][j]);
			}
			System.out.println();
		}
		return this;
	}
	
	private boolean checkBounds(Point p) {
		return !(p.x < 0 || p.y < 0 || p.x >= imgArr.length || p.y >= imgArr.length);
	}
	
	private void fillHelper(int x, int y, char original, char f) {
		if(!checkBounds(new Point(x,y)))
			return;
		
		imgArr[x][y] = f;
		
		if(checkBounds(new Point(x + 1, y)) && original == imgArr[x+1][y]) {
			fillHelper(x + 1, y, original, f);
		}
		if(checkBounds(new Point(x - 1, y)) && original == imgArr[x - 1][y]) {
			fillHelper(x - 1, y, original, f);
		}
		if(checkBounds(new Point(x, y + 1)) && original == imgArr[x][y + 1]) {
			fillHelper(x, y + 1, original, f);
		}
		if(checkBounds(new Point(x, y - 1)) && original == imgArr[x][y - 1]) {
			fillHelper(x, y - 1, original, f);
		}
	}
	
	public Image fill(Point beg, char f) {
		fillHelper(beg.x,beg.y, imgArr[beg.x][beg.y], f);
		return this;
	}
	
	
	public static void main(String[] args) {
		Image image = new Image();
		image.fill(new Point(0,0), 'x')
			 .drawLine(new Point(0,0), new Point(2,6), '*')
			 .drawLine(new Point(5,0), new Point(5,10), 'f')
			 .changeAt(new Point(5,5), 'x')
			 .printImg();
		
	}
}
