package com.payments.finder.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.payments.finder.test.io.IOManagerTest;

@RunWith(Suite.class)
@SuiteClasses({ FinderTest.class, IOManagerTest.class })
public class AllTests {

} 
