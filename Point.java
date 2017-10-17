
public class Point {
		public int x;
		public int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean isGreaterEq(Point p) {
			return x >= p.x && y >= p.y;
		}
		
		public boolean eq(Point p) {
			return x == p.x && y == p.y;
		}
		
		public boolean ne(Point p) {
			return ! eq(p);
		}
	}