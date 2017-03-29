# Change Log

Summary of the changes done in each version.

## 1.3.0-SNAPSHOT (Not yet released)

## 1.2.0 (2017-03-29)

### Updated APIs

 - Core APIs updated for ZAP version 2.6.0.
 - AJAX Spider API
   - Allows to obtain the full results of a scan, messages in/out of scope and message with I/O errors.

## 1.1.1 (2017-03-09)

### Bug Fixes
 - Fixed a bug that prevented the new API methods (that don't require the API key) from being used with ZAP versions <= 2.5.0.

## 1.1.0 (2017-03-09)

### Enhancements
 - The `ClientApi` now allows to set the API key through the constructor, which ensures that the API key is sent whenever required. The API methods that allowed to pass the API key were deprecated in favour of using the new constructor.
 - It's now possible to specify the API key in all Ant tasks.
 - It's now possible to obtain the keys of the values of an `ApiResponseSet` (also, deprecated unused/unnecessary constructor and method).
 - The `Alert` now exposes the alert ID, message ID and scanner ID.
 - Added confidence "False Positive" (enum `Alert.Confidence`).
 - `Alert` and `AlertTask` now use `name` instead of `alert` for the name of the alert (zaproxy/zaproxy#1341), older methods were deprecated.

### Bug Fixes
 - `ApiResponseSet` now has as values `ApiResponse` (zaproxy/zaproxy#3228).

### New APIs

 - Context Alert Filters API, for more information refer to the help page: https://github.com/zaproxy/zap-extensions/wiki/HelpAddonsAlertFiltersAlertFilter

### Updated APIs

 - AJAX Spider API
   - Allows to scan a context, as a user and just a subtree.
 - Selenium API
   - Allows to choose which Firefox binary is used and set the path to geckodriver.

## 1.0.0 (2016-06-03)

First version as "stand alone library", it was migrated from the [zaproxy repository](https://github.com/zaproxy/zaproxy) and released to Maven Central.
