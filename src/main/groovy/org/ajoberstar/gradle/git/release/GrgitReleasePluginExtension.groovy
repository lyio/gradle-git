package org.ajoberstar.gradle.git.release

import org.ajoberstar.gradle.util.ObjectUtil

class GrgitReleasePluginExtension {
	InferredVersion version = new InferredVersion()





	private final Project project
	Grgit grgit
	Set<String> preReleaseSchemes = ['milestone', 'rc']

	Closure includeBuildMetadata = { version -> !version.preReleaseVersion.empty }
	Closure buildMetadata = { }
	boolean useBuildMetadataForPreReleaseOnly = true
	Closure buildMetadata = { grgit.head().id }
	Closure tagRelease = { version -> version.preReleaseVersion.empty }
	Closure tagName = { version -> "v${version}" }
	Closure branchRelease = { version ->
		version.preReleaseVersion.empty &&
			version.patchVersion == 0 &&
			version.minorVersion == 0
	}
	Closure branchName = { version -> "release-${version}" }


	GrgitReleasePluginExtension(Project project) {
		this.project = project
		this.grgit = Grgit.open(project.rootProject.file('.'))
	}

	void version(Closure closure) {

	}

	String getTagName(Version version) {
		return tagRelease(version) ? tagName(version) : null
	}

	String getBranchName(Version version) {
		return branchRelease(version) ? branchName(version) : null
	}

	String getBuildMetadata() {
		return buildMetadata()
	}
}
