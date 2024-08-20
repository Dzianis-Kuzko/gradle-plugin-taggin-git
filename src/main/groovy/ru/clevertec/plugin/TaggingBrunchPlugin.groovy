package ru.clevertec.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.clevertec.plugin.task.*

class TaggingBrunchPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create('gitInfo', GitInfoExtension)

        project.tasks.register('tagging') {
            setGroup('Git')
            dependsOn('publishTagInOrigin')
        }

        project.tasks.register('publishTagInOrigin', PublishTagInOriginTask) {
            setGroup('Git')
            dependsOn('assignTag')
        }

        project.tasks.register('assignTag', AssignTagTask) {
            setGroup('Git')
            dependsOn('hasUncommittedChanges')
        }

        project.tasks.register('hasUncommittedChanges', CheckUncommittedChangesTask) {
            setGroup('Git')
            dependsOn('calculateCurrentVersion')
        }

        project.tasks.register('calculateCurrentVersion', CalculateVersionOfCurrentBuildTask) {
            setGroup('Git')
            dependsOn('lastCommitHasTag')
        }

        project.tasks.register('lastCommitHasTag', CheckHasLastCommitTagTask) {
            setGroup('Git')
            dependsOn('getLastTag')
        }

        project.tasks.register('getLastTag', GetLastTagTask) {
            setGroup('Git')
            dependsOn('getBranchName')
        }

        project.tasks.register('getBranchName', GetCurrentBranchNameTask) {
            setGroup('Git')
            dependsOn('checkGit')
        }

        project.tasks.register('checkGit', CheckGitTask) {
            setGroup('Git')
        }

    }
}
