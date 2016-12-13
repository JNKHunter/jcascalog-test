package tech.eats.art.jcascalogtest;

import com.twitter.maple.tap.StdoutTap;
import jcascalog.Api;
import jcascalog.Subquery;
import jcascalog.example.Split;
import jcascalog.op.Count;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jhunter on 12/13/16.
 */
public class Main {

    public static void main(String[] args) {
        List SENTENCE = Arrays.asList(
                Arrays.asList("Four score and seven years ago our fathers"),
                Arrays.asList("brought forth on this contenent a new nation"),
                Arrays.asList("conceived in Liberty and dedicated to"),
                Arrays.asList("The proposition that all men are created equal")
        );

        Api.execute(new StdoutTap(),
                new Subquery("?word", "?count")
                    .predicate(SENTENCE, "?sentence")
                    .predicate(new Split(), "?sentence").out("?word")
                    .predicate(new Count(), "?count")
        );
    }

}
