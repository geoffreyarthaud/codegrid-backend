package fr.cookiedev.codegrid.utils;

import java.util.UUID;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsAUUID extends TypeSafeMatcher<String> {

	@Override
	public void describeTo(Description description) {
        description.appendText("a UUID");
	}

	@Override
	protected boolean matchesSafely(String item) {
		try{
            UUID.fromString(item);
            return true;
        } catch (IllegalArgumentException exception){
            return false;
        }
	}

	public static Matcher<String> aUUID() {
		return new IsAUUID();
	}

}