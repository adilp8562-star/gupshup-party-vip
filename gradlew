#!/usr/bin/env sh
set -e

GRADLE_VERSION="8.4"
GRADLE_DIST_URL="https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
GRADLE_HOME_DIR="${GRADLE_USER_HOME:-$HOME/.gradle}"
DIST_DIR="$GRADLE_HOME_DIR/wrapper/dists/gradle-${GRADLE_VERSION}-bin"

if [ ! -x "$DIST_DIR/gradle-${GRADLE_VERSION}/bin/gradle" ]; then
  mkdir -p "$DIST_DIR"
  curl -fsSL "$GRADLE_DIST_URL" -o "$DIST_DIR/gradle.zip"
  unzip -qo "$DIST_DIR/gradle.zip" -d "$DIST_DIR"
  chmod +x "$DIST_DIR/gradle-${GRADLE_VERSION}/bin/gradle"
fi

exec "$DIST_DIR/gradle-${GRADLE_VERSION}/bin/gradle" "$@"
