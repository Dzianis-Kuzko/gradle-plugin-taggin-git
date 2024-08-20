package ru.clevertec.plugin.service

class GitService {

    void assignTag(String tag) {
        ('git tag ' + tag).execute()
    }

    boolean isUnderGitControl() {
        Process process = 'git rev-parse --is-inside-work-tree'.execute()
        process.waitFor()
        return process.exitValue() == 0 && process.text.trim() == 'true'
    }

    String getLastTag() {
        return 'git tag --sort=-creatordate --list "v[0-9]*.[0-9]*"'.execute().text.trim().split('\n')[0]
    }

    String getCurrentBranchName() {
        return 'git branch --show-current'.execute().text.trim();
    }

    String getUncommittedChanges() {
        return 'git status -s -uno'.execute().text.trim()
    }

    String getLastCommitTag() {
        return 'git describe --tags --exact-match'.execute().text.trim();
    }

    String getRemote() {
        return 'git remote'.execute().text.trim()
    }

    void publishTag(String tag) {
        ('git push origin ' + tag).execute()
    }
}
