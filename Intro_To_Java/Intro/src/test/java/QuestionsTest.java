import org.junit.Assert;
import org.junit.Test;

public class QuestionsTest {

    Questions questions = new Questions();

    @Test
    public void testQuestion1() {
        String actualResult = questions.question1().toLowerCase().trim();

        if(actualResult.equals("type your answer here".trim())){
            Assert.fail("Have not attempted question");
        }

        if(!actualResult.equals("3") || !actualResult.equals("three")){
            Assert.fail("The answer " + actualResult + " is incorrect. Please review the SuperHero class try answering again.");
        }
    }

    @Test
    public void testQuestion2() {
        String actualResult = questions.question2().toLowerCase().trim();

        if(actualResult.equals("type your answer here".trim())){
            Assert.fail("Have not attempted question");
        }

        if(!actualResult.equals("int") || !actualResult.equals("integer")){
            Assert.fail("The answer " + actualResult + " is incorrect. Please review the SuperHero class try answering again.");
        }
    }

    @Test
    public void testQuestion3() {
        String actualResult = questions.question3().toLowerCase().trim();

        if(actualResult.equals("type your answer here".trim())){
            Assert.fail("Have not attempted question");
        }

        if(!actualResult.equals("2") || !actualResult.equals("two")){
            Assert.fail("The answer " + actualResult + " is incorrect. Please review the SuperHero class try answering again.");
        }
    }

    @Test
    public void testQuestion4() {
        String actualResult = questions.question4().toLowerCase().trim();

        if(actualResult.equals("type your answer here".trim())){
            Assert.fail("Have not attempted question");
        }

        if(!actualResult.equals("class")){
            Assert.fail("The answer " + actualResult + " is incorrect. Please review the SuperHero class try answering again.");
        }
    }

    @Test
    public void testQuestion5() {
        String actualResult = questions.question5().toLowerCase().trim();

        if(actualResult.equals("type your answer here".trim())){
            Assert.fail("Have not attempted question");
        }

        if(!actualResult.equals("method")){
            Assert.fail("The answer " + actualResult + " is incorrect. Please review the SuperHero class try answering again.");
        }
    }

    @Test
    public void testQuestion6() {
        String actualResult = questions.question6().toLowerCase().trim();

        if(actualResult.equals("type your answer here".trim())){
            Assert.fail("Have not attempted question");
        }

        if(!actualResult.equals("variable")){
            Assert.fail("The answer " + actualResult + " is incorrect. Please review the SuperHero class try answering again.");
        }
    }
}
