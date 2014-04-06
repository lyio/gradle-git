/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ajoberstar.gradle.git.semver

import org.ajoberstar.grgit.Grgit
import com.github.zafarkhaja.semver.Version

class InferredVersion {
	private Version inferredVersion = null

	Grgit grgit
	Set<String> stages = ['alpha', 'beta', 'rc']

	Callable<Boolean> useBuildMetadata = { version -> !version.preReleaseVersion.empty }
	Callable<String> buildMetadata = { grgit.head().id }


	void infer(ChangeScope scope, String stage) {

	}




	Grgit grgit
	ReleaseType releaseType
	String preReleaseType


	@Override
	String toString() {
		if (inferredVersion) {
			return inferredVersion
		} else {
			throw new InvalidStateException("Version has not been inferred.")
		}
	}

	static enum ChangeScope {
		MAJOR,
		MINOR,
		PATCH
	}
}
