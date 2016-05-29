Infinite View Pager
===============

Augment Android's ViewPager with wrap-around functionality. Original StackOverflow question: http://stackoverflow.com/questions/7546224/viewpager-as-a-circular-queue-wrapping

## Problem
With a normal ViewPager, you can only scroll from the first page to second page (and so forth), from left-to-right. Once you reach the last page, your only option is to scroll backwards, right-to-left. In other words, 'wrap-around scrolling' (going from first-to-last, and last-to-first) is not possible.

## Solution
Use the `InfiniteViewPager` in your Activity/Fragment layout:
	
``` xml
<com.antonyt.infiniteviewpager.InfiniteViewPager
	android:id="@+id/pager"
	android:layout_width="fill_parent"
	android:layout_height="fill_parent" />
```

Wrap your existing `PagerAdapter` with the `InfinitePagerAdapter`:

``` java
PagerAdapter wrappedAdapter = new InfinitePagerAdapter(adapter);
viewPager.setAdapter(wrappedAdapter);
```


### Installation

To use the library in your project add the following to your project `build.gradle`:

```groovy
dependencies {
    compile 'com.github.antonyt:InfiniteViewPager:v1.0.0'
}
```

And add JitPack repository into your root `build.gradle`:
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

Wrapped scrolling should now be possible with your `ViewPager`. The pages you see are not duplicates - each page from your `PagerAdapter` is only created once and then reused. This means you do not have to worry about managing multiple instances of the same `Fragment`.

## Caveats
It is only possible to achieve wrapping when you have at least 4 pages. This is because of the way the `ViewPager` creates, destroys, and displays the pages. No fix for the general case has been found.
