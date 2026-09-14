#!/usr/bin/env bash
set -e
if ! command -v mvn >/dev/null 2>&1; then
  echo "Maven is required. Install Maven, then run this script again."
  exit 1
fi
mvn clean compile exec:java -Dexec.mainClass=com.mycompany.libraryoperations.LibraryManagementSystem
