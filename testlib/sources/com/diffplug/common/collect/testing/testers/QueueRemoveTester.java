/*
 * Original Guava code is copyright (C) 2015 The Guava Authors.
 * Modifications from Guava are copyright (C) 2016 DiffPlug.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.diffplug.common.collect.testing.testers;

import static com.diffplug.common.collect.testing.features.CollectionFeature.KNOWN_ORDER;
import static com.diffplug.common.collect.testing.features.CollectionFeature.SUPPORTS_REMOVE;
import static com.diffplug.common.collect.testing.features.CollectionSize.ONE;
import static com.diffplug.common.collect.testing.features.CollectionSize.SEVERAL;
import static com.diffplug.common.collect.testing.features.CollectionSize.ZERO;

import java.util.NoSuchElementException;

import com.diffplug.common.annotations.GwtCompatible;
import com.diffplug.common.collect.testing.features.CollectionFeature;
import com.diffplug.common.collect.testing.features.CollectionSize;

/**
 * A generic JUnit test which tests {@code remove()} operations on a queue.
 * Can't be invoked directly; please see
 * {@link com.diffplug.common.collect.testing.CollectionTestSuiteBuilder}.
 *
 * @author Jared Levy
 */
@SuppressWarnings("unchecked") // too many "unchecked generic array creations"
@GwtCompatible
public class QueueRemoveTester<E> extends AbstractQueueTester<E> {
	@CollectionFeature.Require(SUPPORTS_REMOVE)
	@CollectionSize.Require(ZERO)
	public void testRemove_empty() {
		try {
			getQueue().remove();
			fail("emptyQueue.remove() should throw");
		} catch (NoSuchElementException expected) {}
		expectUnchanged();
	}

	@CollectionFeature.Require(SUPPORTS_REMOVE)
	@CollectionSize.Require(ONE)
	public void testRemove_size1() {
		assertEquals("size1Queue.remove() should return first element",
				e0(), getQueue().remove());
		expectMissing(e0());
	}

	@CollectionFeature.Require({KNOWN_ORDER, SUPPORTS_REMOVE})
	@CollectionSize.Require(SEVERAL)
	public void testRemove_sizeMany() {
		assertEquals("sizeManyQueue.remove() should return first element",
				e0(), getQueue().remove());
		expectMissing(e0());
	}
}