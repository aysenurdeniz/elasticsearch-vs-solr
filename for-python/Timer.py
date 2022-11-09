import time


class Timer:
    def __init__(self):
        self.started = None
        self.finished = None

    def start_time(self):
        """
        a method for start time
        :return: none
        """
        self.started = time.perf_counter()

    def finish_time(self):
        """
        a method for distance finish time between start time
        :return: int, float
        """
        self.finished = time.perf_counter()
        distance = (self.finished - self.started) * 1000
        return distance
