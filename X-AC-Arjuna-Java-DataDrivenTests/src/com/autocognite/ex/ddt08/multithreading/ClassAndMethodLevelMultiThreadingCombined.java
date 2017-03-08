/*******************************************************************************
 * Copyright 2015-16 AutoCognite Testing Research Pvt Ltd
 * 
 * Website: www.AutoCognite.com
 * Email: support [at] autocognite.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.autocognite.ex.ddt08.multithreading;

import com.autocognite.arjuna.annotations.*;
import com.autocognite.arjuna.interfaces.ReadOnlyDataRecord;
import com.autocognite.arjuna.interfaces.TestVariables;
import com.autocognite.ex.ddt05.datagenerator.LazyDataGenerator;

import static com.autocognite.arjuna.assertions.Assertions.*;

@TestClass(methodThreads=2)
public class ClassAndMethodLevelMultiThreadingCombined{

	@DriveWithDataGenerator(generatorClass = LazyDataGenerator.class)
	@TestMethod(testThreads=5)
	public void test1(TestVariables testVars) throws Exception{
		ReadOnlyDataRecord record = testVars.dataRecord();
		String actual = String.format("%s::%s", record.value("left"), record.value("right"));
		assertEquals(actual, record.value("EXPECTED"));
	}	
	
	@DriveWithDataGenerator(generatorClass = LazyDataGenerator.class)
	@TestMethod(testThreads=5)
	public void test2(TestVariables testVars) throws Exception{
		ReadOnlyDataRecord record = testVars.dataRecord();
		String actual = String.format("%s::%s", record.value("left"), record.value("right"));
		assertEquals(actual, record.value("EXPECTED"));
	}	
}
