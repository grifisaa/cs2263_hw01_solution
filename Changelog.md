# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [1.2.0] - 2021-08-20
### Added
- Added the output mode processing for both console and file output modes

### Changed
- Modified the input modes to use the output modes for output rather than direct calls to System.out
- Modified App to correctly process the `output` command line option, and refactored the class to improve maintainability
- Updated all comments and version numbers of the files

## [1.1.0] - 2021-08-20
### Added
- Added in the ability to evaluate expressions
- Added the ability to process input either interactively or via a batch file

### Changed
- Modified the processing of the `batch` command line option to now turn on batch file processing

## [1.0.0] - 2021-08-20
### Added
- Added basic project structure including automated build, readme, etc.
- Implemented basic command line processing capabilities

[Unreleased]: https://https://github.com/grifisaa/cs2263_hw01_solution/compare/v1.2.0...HEAD
[v1.2.0]: https://https://github.com/grifisaa/cs2263_hw01_solution/compare/v1.0.0...v1.1.0
[v1.1.0]: https://https://github.com/grifisaa/cs2263_hw01_solution/compare/v1.0.0...v1.1.0
[v1.0.0]: https://https://github.com/grifisaa/cs2263_hw01_solution/releases/tag/v0.0.1
