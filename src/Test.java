import com.unimelb.cis.geometry.Mbr;
import com.unimelb.cis.node.Point;
import com.unimelb.cis.structures.recursivemodel.OriginalRecursiveModel;

import java.util.Arrays;
import java.util.List;

import static com.unimelb.cis.Test.testRecursivePartition;

public class Test {

    public static void testOriginalRecursiveModel(String s, List<Point> insertedPoints, List<Mbr> mbrs, List<Point> knnPoints, int k) {
        System.out.println("------------------------------------------------");
        System.out.println("OriginalRecursive");
        OriginalRecursiveModel originalRecursiveModel1 = new OriginalRecursiveModel(100, false, "Z", 2);
        System.out.println(originalRecursiveModel1.buildRtree(s));
        System.out.println("pointQuery:" + originalRecursiveModel1.pointQuery(originalRecursiveModel1.getPoints()));
        System.out.println("windowQuery:" + originalRecursiveModel1.windowQuery(mbrs));
        System.out.println("windowQueryByScanAll:" + originalRecursiveModel1.windowQueryByScanAll(mbrs));
        System.out.println("knn query:" + originalRecursiveModel1.knnQuery(knnPoints, k));
        System.out.println("insert:" + originalRecursiveModel1.insert(insertedPoints));
    }

    public static void main(String[] args) {

        int k = 1;
        int dim = 2;

        List<Float> sides = Arrays.asList(0.04f);

        // TODO add your data set(like  :  22.1111 22.1111 1)
        // ref: https://github.com/Liuguanli/SpatialIndices
        List<String> datasets = Arrays.asList();

        datasets.forEach(s -> {
            List<Point> knnPoints = Point.getPoints(10, 2);
            List<Point> insertedPoints = Point.getPoints(10000, 2);
            sides.forEach(aFloat -> {
                List<Mbr> mbrs = Mbr.getMbrs(aFloat, 10, 2);
                testRecursivePartition(s, insertedPoints, mbrs, knnPoints, k);
            });
        });


    }


}
