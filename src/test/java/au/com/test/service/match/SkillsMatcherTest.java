package au.com.test.service.match;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import au.com.test.model.Job;
import au.com.test.model.Worker;

public class SkillsMatcherTest {

	@Test
	public void test_match() {
		SkillsMatcher m = new SkillsMatcher();
		Worker w = new Worker();
		w.setSkills(Arrays.asList("Skill 1", "Skill 2"));

		Job j = new Job();
		j.setJobTitle("Skill 1");

		assertTrue(m.match(w, j));
	}

	@Test
	public void test_match_false() {
		SkillsMatcher m = new SkillsMatcher();
		Worker w = new Worker();
		w.setSkills(Arrays.asList("Skill 1", "Skill 2"));

		Job j = new Job();
		j.setJobTitle("Skill 3");

		assertFalse(m.match(w, j));
	}
}
