Infinite View Pager
===============

Augment Android's ViewPager with wrap-around functionality. Original StackOverflow question: http://stackoverflow.com/questions/7546224/viewpager-as-a-circular-queue-wrapping

## Problem
With a normal ViewPager, you can only scroll from the first page to second page (and so forth), from left-to-right. Once you reach the last page, your only option is to scroll backwards, right-to-left. In other words, 'wrap-around scrolling' (going from first-to-last, and last-to-first) is not possible.

## Solution
Use the `InfiniteViewPager` in your Activity/Fragment layout:
	
	...
	<com.antonyt.infiniteviewpager.InfiniteViewPager
		android:id="@+id/pager"
		android:layout_width="fill_parent"
		android:layout_height="fill_parent" />
	...

Wrap your existing `PagerAdapter` with the `InfinitePagerAdapter`:

	...
	PagerAdapter wrappedAdapter = new InfinitePagerAdapter(adapter);
	viewPager.setAdapter(wrappedAdapter);
	...


### Gradle build

To install the demo application to your device run the following task:

```
$ ./gradlew installDebug
```

To deploy the library to your local Maven repository run the following task:

```
$ ./gradlew install
```

Then, to use the library in your project add the following to your `build.gradle`:

```groovy
dependencies {
    compile 'com.antonyt.infiniteviewpager:library:1.0.0'
}
```

Wrapped scrolling should now be possible with your `ViewPager`. The pages you see are not duplicates - each page from your `PagerAdapter` is only created once and then reused. This means you do not have to worry about managing multiple instances of the same `Fragment`.

## Caveats
It is only possible to achieve wrapping when you have at least 4 pages. This is because of the way the `ViewPager` creates, destroys, and displays the pages. No fix for the general case has been found.