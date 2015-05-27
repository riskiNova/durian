#!/bin/bash
# This script initiates the Gradle publishing task when pushes to master occur.
# NOTE: Travis-CI can only publish SNAPSHOT versions.
if [ "$TRAVIS_REPO_SLUG" == "DiffPlug/durian" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then
	if [[ $(./gradlew -q getVersion) != *SNAPSHOT* ]]; then
			echo 'Travis can only publish snapshots.'
			return 0
	fi

	echo -e "Starting publish to Sonatype...\n"
	./gradlew publish -Pnexus_user="${nexus_user}" -Pnexus_pass="${nexus_pass}"
	RETVAL=$?

	if [ $RETVAL -eq 0 ]; then
		echo 'Completed publish!'
	else
		echo 'Publish failed.'
		return 1
	fi
fi
