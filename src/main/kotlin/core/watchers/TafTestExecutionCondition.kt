package core.watchers

import org.junit.jupiter.api.extension.ConditionEvaluationResult
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ExtensionContext

class TafTestExecutionCondition: ExecutionCondition {
  override fun evaluateExecutionCondition(context: ExtensionContext?): ConditionEvaluationResult {
    return when (context?.element?.get()?.isAnnotationPresent(StopTest::class.java)) {
      true -> ConditionEvaluationResult.disabled("Test stop because it has annotation @StopTest")
      else -> ConditionEvaluationResult.enabled("Test run because it have annotation @StopTest")
    }
  }
}