package org.ligi.passandroid.model.comparator;

import org.ligi.passandroid.model.AndroidFileSystemPassStore;
import org.ligi.passandroid.model.Pass;

import java.util.Comparator;

public class PassByTypeFirstAndTimeSecondComparator implements Comparator<Pass> {

    private final PassByTimeComparator passByTimeComparator = new PassByTimeComparator();

    @Override
    public int compare(Pass lhs, Pass rhs) {
        if (lhs.getType() == rhs.getType()) { // that looks bad but makes sense for both being null
            return 0;
        }

        if (lhs.getType() == null) {
            return 1;
        }
        if (rhs.getType() == null) {
            return -1;
        }
        final int compareResult = lhs.getType().compareTo(rhs.getType());

        if (compareResult != 0) {
            return compareResult;
        } else {
            return passByTimeComparator.compare(lhs, rhs);
        }
    }
}
