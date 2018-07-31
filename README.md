# CPEData
Android native object mapping for MovieLabs Cross-Platform Extras Manifest, Common Metadata, AppData and Style specs.
Compatible with [cpe-manifest-android-experience](https://github.com/warnerbros/cpe-manifest-android-experience) branch "feature/separating-parser" for a full UI implementation.
P.S. "feature/separating-parser" is WIP, it will be merged into master when its completely done.

## Workspace ##
1. Download Android Studio
2. Check out this repository
3. Open the "sample" folder for a sample of how to use the library


## How to include this library and build with Grade locally##
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
1. create an ManifestItem Object with the urls of the CPE Manifest file, AppData file and CPE Style file.
2. Use the static function in CPEDataParser.parseCPEManifests, supply the Application Context, the ManifestItem Object and the Locale (for future multi-language support).
3. Function will return a CPEData object after parsing the three xml files.
