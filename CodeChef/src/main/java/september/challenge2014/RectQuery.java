package september.challenge2014;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RectQuery {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

    }

    static class Rectangle {
        Point p1;
        Point p2;

        public Rectangle(Point p1, Point p2) {
            super();
            this.p1 = p1;
            this.p2 = p2;
        }

        public boolean isInside(Point p) {
            return p1.x <= p.x && p2.x >= p.x && p1.y <= p.y && p2.y >= p.y;
        }

        public boolean overLaps(Rectangle r) {
            return r.isInside(this.p1) || r.isInside(p2) || isInside(r.p1) || isInside(r.p2);
        }

        @Override
        public String toString() {
            return "[" + p1.toString() + "," + p2.toString() + "";
        }
    }

    public static void main(String[] args) throws IOException {

        // BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
        // System.in));
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
                new FileInputStream(new
                        File("src/main/resources/rectanglequery/input.txt"))));
        int n = Integer.parseInt(bufferRead.readLine());
        Map<Integer, Rectangle> points = new HashMap<Integer, RectQuery.Rectangle>();
        for (int i = 0; i < n; ++i) {
            String[] splits = bufferRead.readLine().split(" ");
            if (splits[0].equals("I")) {
                Rectangle rectangle = getRectangle(splits);
                points.put(new Integer(i + 1), rectangle);
            }
            else if (splits[0].equals("D"))
                points.remove(Integer.parseInt(splits[1]));
            else {
                Collection<Rectangle> values = points.values();
                int counter = 0;
                for (Iterator<Rectangle> itr = values.iterator(); itr.hasNext();) {
                    Rectangle rectangle = itr.next();
                    if (rectangle.overLaps(getRectangle(splits))) {
                        counter++;
                    }
                }
                System.out.println(counter);
            }
            // System.out.println(points);
        }
        logMemory();
        bufferRead.close();

    }

    private static Rectangle getRectangle(String[] splits) {
        int x1 = Integer.parseInt(splits[1]);
        int y1 = Integer.parseInt(splits[2]);
        int x2 = Integer.parseInt(splits[3]);
        int y2 = Integer.parseInt(splits[4]);
        Rectangle rectangle = new Rectangle(new Point(x1, y1), new Point(x2, y2));
        return rectangle;
    }

    public static void logMemory() {
        ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        System.out.println("Heap: " + ManagementFactory.getMemoryMXBean().getHeapMemoryUsage());
        System.out.println("NonHeap: " + ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage());
        List<MemoryPoolMXBean> beans = ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean bean : beans) {
            System.out.println(bean.getName() + " : " + bean.getUsage());
        }

        for (GarbageCollectorMXBean bean : ManagementFactory.getGarbageCollectorMXBeans()) {
            System.out.println(bean.getName() + " : " + bean.getCollectionCount() + " : " + bean.getCollectionTime());
        }
    }
}
