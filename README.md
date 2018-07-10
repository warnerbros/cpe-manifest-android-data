# CPEData
Android native object mapping for MovieLabs Cross-Platform Extras Manifest, Common Metadata, AppData and Style specs, compatible with [CPEExperience](https://github.com/warnerbros/cpe-manifest-android-experience) for a full UI implementation.

## Workspace ##
1. Download Android Studio
2. Check out NextGen Android at this repository, e.g. NextGen/Android folder
## How to build with Grade ##
### Set Up ###
3. In the root directory, add project into settings.gradle and build.gradle

	settings.gradle:

		include 'cpe-manifest-android-data'...

	build.gradle:

		...

        dependencies {
            ...
            compile project(':cpe-manifest-android-data')
        }
        ...
## Usage

Use the static